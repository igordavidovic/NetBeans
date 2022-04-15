@ECHO OFF

SET HOUR=%time:~0,2%
SET dtStamp9=%date:~-4%%date:~4,2%%date:~7,2%_0%time:~1,1%%time:~3,2%%time:~6,2%
SET dtStamp24=%date:~-5,4%%date:~7,2%%date:~4,2%%time:~0,2%%time:~3,2%%time:~6,2%


if "%HOUR:~0,1%" == " " (SET dtStamp=%dtStamp9%) else (SET dtStamp=%dtStamp24%)

set naziv=%dtStamp%zavrsni

c:\xampp\mysql\bin\mysqldump -uedunova -pedunova recepcija > d:\%naziv%.sql

"C:\Program Files\7-Zip\7z.exe" a -tzip C:\Users\Igor\OneDrive\Documents\backup.zip d:\%naziv%.sql

del d:\%naziv%.sql

ECHO "GOTOV"