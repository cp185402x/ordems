@echo off
 
set dbUser=root
set dbPassword=
set backupDir="C:\Users\edba\ordems\banco"
set mysqldump="C:\xampp\mysql\bin\mysqldump.exe"
set mysqlDataDir="C:\xampp\mysql\data"
set zip="C:\Program Files\7-Zip\7z.exe"
 
for /F "tokens=1-3 delims=/ " %%i in ('date /t') do (
set dd=%%i
set mm=%%j
set yy=%%k
)
 
for /F "tokens=1-2 delims=:. " %%i in ('time /t') do (
set hh=%%i
set ss=%%j
)
 
set dirName=%yy%%mm%%dd%-%hh%%ss%
 
pushd %mysqlDataDir%
 
for /d %%f in (*) do (
 
if not exist %backupDir%\%dirName%\ (
mkdir %backupDir%\%dirName%
)
 
%mysqldump% --host="localhost" --user=%dbUser% --password=%dbPassword% --single-transaction --add-drop-table --databases %%f > %backupDir%\%dirName%\%%f.sql
 
%zip% a -tgzip %backupDir%\%dirName%\%%f.sql.gz %backupDir%\%dirName%\%%f.sql
 
del %backupDir%\%dirName%\%%f.sql
 
)