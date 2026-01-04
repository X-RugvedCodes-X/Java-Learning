@echo off
setlocal enabledelayedexpansion

REM ---- Check argument ----
if "%~1"=="" (
echo Usage: build ClassName OR build ClassName.java
exit /b 1
)

REM ---- Extract class name ----
set CLASSNAME=%~n1

REM ---- Config ----
set SRC_ROOT=src
set OUT_DIR=out

REM ---- Find source file ----
for /f "delims=" %%f in ('where /r "%SRC_ROOT%" %CLASSNAME%.java 2^>nul') do (
  set SRC_FILE=%%f
  goto :found
)

echo Error: %CLASSNAME%.java not found under %SRC_ROOT%
exit /b 1

:found

REM ---- Make path relative to project root ----
set REL_SRC_FILE=!SRC_FILE:%CD%\=!

echo Found: !REL_SRC_FILE!
echo.

REM ---- Create output dir ----
if not exist "%OUT_DIR%" mkdir "%OUT_DIR%"

REM ---- Compile ----
echo Compiling with Debug Symbols for jdb
echo ^> javac -g -cp "%OUT_DIR%" -d "%OUT_DIR%" "!REL_SRC_FILE!"
javac -g -cp "%OUT_DIR%" -d "%OUT_DIR%" "!SRC_FILE!"
if errorlevel 1 exit /b 1

REM ---- Extract package name ----
set PACKAGE=
for /f "tokens=2 delims= " %%p in ('findstr /r "^package " "!SRC_FILE!"') do (
  set PACKAGE=%%p
)
set PACKAGE=!PACKAGE:;=!

echo.

REM ---- Run ----
if defined PACKAGE (
  echo Running...
  echo ^> java -cp "%OUT_DIR%" !PACKAGE!.%CLASSNAME%
  java -cp "%OUT_DIR%" !PACKAGE!.%CLASSNAME%
) else (
  echo Running...
  echo ^> java -cp "%OUT_DIR%" %CLASSNAME%
  java -cp "%OUT_DIR%" %CLASSNAME%
)

endlocal