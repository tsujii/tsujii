#!/bin/bash

find /home/tullys1/20130704/log4j/ | grep \.class > tmp.log

while read line ; do

    DIR_NAME=${line%/*}
    FILE_NAME=${line##*/}

    JAD_FILE=`echo ${FILE_NAME} | sed 's/\.class/\.jad/gi'`
    JAVA_FILE=`echo ${FILE_NAME} | sed 's/\.class/\.java/g'`

    echo " cd $DIR_NAME"
    echo " jad \"${FILE_NAME}\"
    echo " rm -f \"${FILE_NAME}\"
    echo " mv \"${JAD_FILE}\" \"${JAVA_FILE}\" "

done < tmp.log

/bin/rm -f tmp.log
