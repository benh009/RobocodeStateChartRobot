#!/bin/sh
CLASSPATH=
pwd=`pwd`
cd "${0%/*}"
java -Xmx512M -Dsun.io.useCanonCaches=false -DNOSECURITY=true -DlogMessages=true -Ddebug=true -DPARALLEL=true -classpath ../../bin/:libs/robocode.jar:../robotStateChart/commons-scxml-2/antlr-2.7.7.jar:../robotStateChart/commons-scxml-2/asm-4.1.jar:../robotStateChart/commons-scxml-2/asm-analysis-4.1.jar:../robotStateChart/commons-scxml-2/asm-commons-4.1.jar:../robotStateChart/commons-scxml-2/asm-tree-4.1.jar:../robotStateChart/commons-scxml-2/asm-util-4.1.jar:../robotStateChart/commons-scxml-2/commons-jexl-2.1.1.jar:../robotStateChart/commons-scxml-2/commons-jexl-2.1.1-bin.tar.gz:../robotStateChart/commons-scxml-2/commons-logging-1.1.3.jar:../robotStateChart/commons-scxml-2/commons-scxml2-2.0-SNAPSHOT.jar:../robotStateChart/commons-scxml-2/groovy-2.2.2.jar:../robotStateChart/commons-scxml-2/hamcrest-core-1.3.jar:../robotStateChart/commons-scxml-2/junit-4.11.jar robocode.Robocode $*
cd "${pwd}"
