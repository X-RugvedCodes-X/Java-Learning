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

REM ---- Find source file ----
set SRC_FILE=
for /r "%SRC_ROOT%" %%f in (%CLASSNAME%.java) do (
  set SRC_FILE=%%f
)

if not defined SRC_FILE (
  echo Error: %CLASSNAME%.java not found under %SRC_ROOT%
  exit /b 1
)

REM ---- Make SRC_FILE relative to project root (for display only) ----
set REL_SRC_FILE=!SRC_FILE:%CD%\=!

REM ---- Make path relative to src/ for package calculation ----
set REL_PATH=!SRC_FILE:*%SRC_ROOT%\=!
set REL_PATH=!REL_PATH:\%CLASSNAME%.java=!

REM ---- Convert path to package name ----
set PACKAGE_NAME=!REL_PATH:\=.!

REM ---- Debug ----
echo Debugging %PACKAGE_NAME%.%CLASSNAME% ...
echo Using source: %REL_SRC_FILE%
jdb -classpath "%OUT_DIR%" %PACKAGE_NAME%.%CLASSNAME%

endlocal
