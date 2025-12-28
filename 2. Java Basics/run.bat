@echo off
setlocal enabledelayedexpansion

REM ---- Check argument ----
if "%~1"=="" (
  echo Usage: run ClassName OR run ClassName.java
  exit /b 1
)

REM ---- Extract class name ----
set CLASSNAME=%~n1

REM ---- Config ----
set SRC_ROOT=src
set OUT_DIR=out

REM ---- Find source file (to get package) ----
for /f "delims=" %%f in ('where /r "%SRC_ROOT%" %CLASSNAME%.java 2^>nul') do (
  set SRC_FILE=%%f
  goto :found
)

echo Error: %CLASSNAME%.java not found under %SRC_ROOT%
exit /b 1

:found

REM ---- Make path relative to project root (display only) ----
set REL_SRC_FILE=!SRC_FILE:%CD%\=!

REM ---- Extract package name ----
set PACKAGE=
for /f "tokens=2 delims= " %%p in ('findstr /B /C:"package " "!SRC_FILE!"') do (
  set PACKAGE=%%p
)
set PACKAGE=!PACKAGE:;=!

REM ---- Check if class file exists ----
if defined PACKAGE (
  set CLASS_FILE=%OUT_DIR%\!PACKAGE:.=\!\%CLASSNAME%.class
) else (
  set CLASS_FILE=%OUT_DIR%\%CLASSNAME%.class
)

if not exist "!CLASS_FILE!" (
  echo Error: Class not compiled.
  echo Expected: !CLASS_FILE!
  echo Run build %CLASSNAME% first.
  exit /b 1
)

REM ---- Run ----
echo Using source: !REL_SRC_FILE!
echo.

echo Running...
if defined PACKAGE (
  echo ^> java -cp "%OUT_DIR%" !PACKAGE!.%CLASSNAME%
  java -cp "%OUT_DIR%" !PACKAGE!.%CLASSNAME%
) else (
  echo ^> java -cp "%OUT_DIR%" %CLASSNAME%
  java -cp "%OUT_DIR%" %CLASSNAME%
)

endlocal
