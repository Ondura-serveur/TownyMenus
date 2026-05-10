@echo off


:: /Y force le remplacement sans demander
copy /Y "build\libs\TownyMenus*.jar" "C:\Users\adrie\Desktop\ondura\serveur\plugins"

if %ERRORLEVEL% EQU 0 (
    echo [SUCCES] Le plugin a ete deploye !
) else (
    echo [ERREUR] Impossible de copier le fichier.
)