ANTLR_PATH := ../antler/antlr-4.5.3-complete.jar
SRC_DIR := src
BUILD_DIR := _build

MAIN = App

ANTLR4=java -jar $(ANTLR_PATH)

CLASSES := ./src/**/*.java
CLASSES += ./src/*.java

JAVAC=javac -classpath '$$CLASSPATH:$(ANTLR_PATH)' -d $(BUILD_DIR)

all: clean build run

clean :
	rm -rf $(BUILD_DIR)

build : build_parser

build_parser :
	mkdir -p $(BUILD_DIR)
	$(ANTLR4) -o $(SRC_DIR) parser/uml_grammar.g4
	$(JAVAC) $(CLASSES)

run :
	java -cp "$(BUILD_DIR):$(ANTLR_PATH)" $(MAIN) parser/testFiles/League.ucd
