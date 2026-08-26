@echo off
chcp 65001 >nul
setlocal

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
javac -encoding UTF-8 -cp "gson-2.14.0.jar" -d bin @sources.txt

if errorlevel 1 (
    echo.
    echo ===== ERRO NA COMPILACAO =====
    del sources.txt
    exit /b 1
)

del sources.txt

echo.
echo ===== COMPILADO COM SUCESSO =====