; Java Launcher Utilize NSIS

; EXE description
Name "DarkRoom"
Caption ""
Icon "icon.ico"
OutFile "darkroom.exe"

; Run as admin
; param below can be user, admin    
RequestExecutionLevel admin

; Hide the install window
SilentInstall silent
AutoCloseWindow true
ShowInstDetails show

Section "Execute Java"
  ; command to execute java
  StrCpy $0 "javaw -jar darkroom.jar"
  SetOutPath $EXEDIR
  Exec $0
SectionEnd