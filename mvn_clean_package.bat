@echo off

:INPUT
echo  c.ִ��clean����
echo  p.ִ��package����
echo  s.ִ������source�ļ�����
echo  e.ִ��eclipse����
echo  d ִ��deploy����
echo  q.�˳�

echo ������Ҫѡ������
set /p cmd=
IF %cmd% == c GOTO CLEAN
IF %cmd% == p GOTO PACKAGE
IF %cmd% == s GOTO SOURCES
IF %cmd% == e GOTO ECLIPSE
IF %cmd% == a GOTO ASSEMBLY
IF %cmd% == d GOTO DEPLOY
IF %cmd% == q GOTO END

:ECLIPSE
call mvn eclipse:clean
call mvn eclipse:eclipse -U -DdownloadSources=true -DdownloadJavadocs=false
echo ============================================================================
echo =========================== eclipse is complete===============================
echo ============================================================================
GOTO INPUT

:CLEAN
call mvn eclipse:clean
call mvn clean
echo ============================================================================
echo =========================== clean is complete===============================
echo ============================================================================
GOTO INPUT

:PACKAGE
call mvn clean
call mvn -Dmaven.test.skip=true -Dmaven.javadoc.skip=true install
echo ============================================================================
echo =========================== package is complete=============================
echo ============================================================================
GOTO INPUT


:SOURCES
call mvn clean source:jar install
echo ============================================================================
echo =========================== sources is complete=============================
echo ============================================================================
GOTO INPUT

:DEPLOY
call mvn deploy
echo ============================================================================
echo =========================== deploy is complete=============================
echo ============================================================================
GOTO INPUT

:END
@pause

