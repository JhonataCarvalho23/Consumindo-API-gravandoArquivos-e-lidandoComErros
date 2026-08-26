@echo off
chcp 65001 >nul
setlocal EnableDelayedExpansion

set /p CLASSE=Digite o nome da classe que deseja executar: 

rem Remove .java caso tenha sido digitado
set "CLASSE=%CLASSE:.java=%"

echo.
echo Procurando a classe...
echo.

set "ARQUIVO="

for /r "src" %%f in (%CLASSE%.java) do (
    set "ARQUIVO=%%f"
)

if not defined ARQUIVO (
    echo Classe "%CLASSE%" nao encontrada dentro da pasta src.
    echo.
    pause
    exit /b
)

echo Classe encontrada:
echo !ARQUIVO!
echo.

set "PACKAGE="

for /f "tokens=2" %%p in ('findstr /b "package " "!ARQUIVO!"') do (
    set "PACKAGE=%%p"
)

if defined PACKAGE (
    set "PACKAGE=!PACKAGE:;=!"
    set "CLASSE_COMPLETA=!PACKAGE!.%CLASSE%"
) else (
    set "CLASSE_COMPLETA=%CLASSE%"
)

echo ===== EXECUTANDO =====
echo.
echo Classe: !CLASSE_COMPLETA!
echo.

java -cp "bin;gson-2.14.0.jar" !CLASSE_COMPLETA!

echo.