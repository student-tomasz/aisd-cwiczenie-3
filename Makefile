JC=javac
CFLAGS=-g
SOURCES= \
	Heap.java \
	PQueue.java \
	PQueueTest.java
CLASSES=$(subst .java,.class,$(SOURCES))

all:
	javac -g $(SOURCES)

clean:
	rm -rf $(CLASSES)

run: all
	java PQueueTest

.PHONY: all clean run
