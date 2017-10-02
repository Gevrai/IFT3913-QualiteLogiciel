SRC_DIR := src
BUILD_DIR := _build

MAIN = App

# CLASSES := ./src/**/*.java
# CLASSES += ./src/*.java
CLASSES := ./src/App.java
CLASSES += ./src/util/FileReader.java

JAVAC=javac -d $(BUILD_DIR)

all: clean build run

clean :
	rm -rf $(BUILD_DIR)

build : build_parser

build_parser :
	mkdir -p $(BUILD_DIR)
	$(JAVAC) $(CLASSES)

run :
	java -cp "$(BUILD_DIR)" $(MAIN) testFiles/League.ucd
