@echo off
setlocal EnableDelayedExpansion

cd /d "%~dp0"

echo.
echo ===== LIMPANDO BIN =====
if not exist bin mkdir bin
del /s /q bin\*.class >nul 2>&1

echo.
echo ===== ENCONTRANDO ARQUIVOS JAVA =====
dir /s /b src\*.java > sources.txt

echo.
echo ===== COMPILANDO =====
javac -encoding UTF-8 -d bin @sources.txt

if errorlevel 1 (
    echo.
    echo ===== ERRO NA COMPILACAO =====
    del sources.txt
    pause
    exit /b 1
)

del sources.txt

echo.
echo ===== COMPILADO COM SUCESSO =====
echo.

set "FILE=%~1"

for /f "tokens=2" %%P in ('findstr /R /C:"^package " "%FILE%"') do set "PACKAGE=%%P"

set "PACKAGE=!PACKAGE:;=!"

for %%F in ("%FILE%") do set "CLASS=%%~nF"

if defined PACKAGE (
    set "MAIN=!PACKAGE!.!CLASS!"
) else (
    set "MAIN=!CLASS!"
)

echo Executando: !MAIN!
echo.

java -cp bin "!MAIN!"

echo.
pause