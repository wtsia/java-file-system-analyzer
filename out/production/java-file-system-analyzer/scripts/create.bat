@echo off

REM Create directories
mkdir Test_Files
cd Test_Files
mkdir Documents
mkdir Images
mkdir Videos

REM Create files
cd Documents
echo Sample text for document 1 > document1.txt
echo Another document content > document2.txt

cd ..\Images
echo Image file content > image1.jpg
echo Another image content > image2.png

cd ..\Videos
echo Video data for testing > video1.mp4
echo More video content > video2.mov

echo Test files created.
