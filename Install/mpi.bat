c:
md c:\javapractice\%1
md c:\javapractice\%1\src
md c:\javapractice\%1\bin
md c:\javapractice\%1\.settings
copy c:\javapractice\template\src\templatei.java  c:\javapractice\%1\src\%1.java
copy c:\javapractice\template\.classpath  c:\javapractice\%1\.classpath
copy c:\javapractice\template\.project  c:\javapractice\%1\.project
copy c:\javapractice\template\.settings\*.*  c:\javapractice\%1\.settings\*.*

c:\tools\bin\sed s/Template/%1/ c:\JavaPractice\Template\src\Templatei.java > c:\JavaPractice\%1\src\%1.java
c:\tools\bin\sed s/Template/%1/ c:\JavaPractice\Template\.project > c:\JavaPractice\%1\.project
cd c:\javapractice\%1
C:\eclipse\eclipse.exe -import c:\javapractice\%1



 


