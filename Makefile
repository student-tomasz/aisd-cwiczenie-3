JC=javac
CFLAGS=-g -cp .:lib/guava-10.0.1.jar
RFLAGS=-cp .:lib/guava-10.0.1.jar
SOURCES= \
	PQueueOnTreeMultimap.java \
	PQueue.java \
	PQueueTest.java
CLASSES=$(subst .java,.class,$(SOURCES))

all:
	javac $(CFLAGS) $(SOURCES)

clean:
	rm -rf $(CLASSES)

run: all
	java $(RFLAGS) PQueueTest

.PHONY: all clean run
