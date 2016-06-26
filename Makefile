DESFOLDER = classes
DES = -d $(DESFOLDER)
DESCHE = -classpath $(DESFOLDER)
SRCCHE = -classpath src
CC = javac
RUN = java -cp $(DESFOLDER)
DOC = javadoc -classpath src
JAR = jar cvfm
RMIC = rmic
RMICREG = rmiregistry

all: compHello doc runServer

doc:
	@echo "__GENERATION OF THE DOCUMENTATION __________________"
	mkdir -p docs
	$(DOC) -subpackages rmiHello -d docs

compHello:
	@echo "__COMPILATION OF THE HELLO PROJECT _________________"
	$(CC) $(DES) $(SRCCHE) src/rmiHello/*.java
	$(RMIC) $(DESCHE) $(DES) rmiHello.HelloImpl


jarHello:
	@echo "__CREATION OF THE JAR _______________________________"
	@echo "DO NOT WORK"
	@echo DO NOT WORK
	make compHello
	$(JAR) Hello.jar manifest-ex . -C classes .

runServer:
	@echo "__RUN THE HELLO PROJECT SERVER ______________________"
	$(RMICREG) -J-cp -Jclasses &
	$(RUN) rmiHello.ServeurTp1

runClient:
	@echo "__RUN THE HELLO PROJECT CLIENT ______________________"
	$(RUN) rmiHello.ClientIHM

runJar:
	@echo "__RUN THE JAR _______________________________________"
	@echo "DO NOT WORK"
	java -jar Hello.jar

help:
	@echo "__HELP ______________________________________________"
	@echo "You can use :"
	@echo "all : Launch compilation of the Hello rmi then doc then run the server."
	@echo "compHello : compil all the .java of the rmiHello project."
	@echo "doc : product the doc."
	@echo "jar : create a jar than we can run."
	@echo "runServer : run the server of the Hello."
	@echo "runClient : run a Client of the Hello."
	@echo "help : help with the Make file."
	@echo "clean : Clean all the folders. (.class, Hello.jar, temp files, doc...)"

.PHONY: clean

clean:
	@echo "__CLEANING _________________________________________"
	rm -rf **/*.class classes/* docs/* test/test/*.class *~ **/*~ Hello.jar
	killall -9 rmiregistry
