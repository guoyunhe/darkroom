; Java Launcher
;--------------

; You want to change the below lines   
Name "小黑屋"   
Caption "小黑屋安装程序"    
;Icon "iconfile.ico"    
OutFile "DarkRoom.exe"

; param below can be user, admin    
RequestExecutionLevel admin

SilentInstall silent
AutoCloseWindow true
ShowInstDetails show

Section ""    
  ; command to execute    
  StrCpy $0 "javaw -jar darkroom.jar"
  SetOutPath $EXEDIR    
  Exec $0    
SectionEnd