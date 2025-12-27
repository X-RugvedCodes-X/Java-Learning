@echo off
setlocal enabledelayedexpansion

REM ---- Check argument ----
if "%~1"=="" (
echo Usage: debug ClassName OR debug ClassName.java
exit /b 1
)

REM ---- Extract class name ----
set CLASSNAME=%~n1

REM ---- Config ----
set SRC_ROOT=src
set OUT_DIR=out

REM ---- Find source file (robust) ----
for /f "delims=" %%f in ('where /r "%SRC_ROOT%" %CLASSNAME%.java 2^>nul') do (
  set SRC_FILE=%%f
  goto :found
)

echo Error: %CLASSNAME%.java not found under %SRC_ROOT%
exit /b 1

:found

REM ---- Relative path for display ----
set REL_SRC_FILE=!SRC_FILE:%CD%\=!

REM ---- Extract package from source ----
set PACKAGE=
for /f "tokens=2 delims= " %%p in ('findstr /r "^package " "!SRC_FILE!"') do (
  set PACKAGE=%%p
)
set PACKAGE=!PACKAGE:;=!

REM ---- Output ----
echo Using source: !REL_SRC_FILE!
echo.

REM ---- Debug ----
if defined PACKAGE (
  echo Debugging...
  echo ^> jdb -classpath "%OUT_DIR%" !PACKAGE!.%CLASSNAME%
  jdb -classpath "%OUT_DIR%" !PACKAGE!.%CLASSNAME%
) else (
  echo Debugging...
  echo ^> jdb -classpath "%OUT_DIR%" %CLASSNAME%
  jdb -classpath "%OUT_DIR%" %CLASSNAME%
)

endlocal
