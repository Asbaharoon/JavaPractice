copy mp.bat c:\windows\system32
copy mpi.bat c:\windows\system32
copy *.jar c:\eclipse\plugins
md c:\javapractice
md c:\javapractice\Template
xcopy Template\*.* c:\javapractice\Template /s
md c:\tools
md c:\tools\bin
xcopy sed\*.* c:\tools\bin /s
