SRC_DIR := src
BUILD_DIR := _build

MAIN = App

CLASSES := \
	./src/util/*.java \
	./src/uml/**/*.java \
	./src/uml/*.java \
	./src/parser/*.java \
	./src/gui/*.java \
	./src/*.java \

JAVAC=javac -d $(BUILD_DIR)

## all   -> Base rule : Compiles from scratch and run the program
all: clean build run

## help  -> Shows this help.
help:
	@fgrep -h "##" $(MAKEFILE_LIST) | fgrep -v fgrep | sed -e 's/\\$$//' | sed -e 's/##//'
## clean -> Cleans the build directory
clean :
	rm -rf $(BUILD_DIR)

## build -> Builds the entire program
build :
	mkdir -p $(BUILD_DIR)
	$(JAVAC) $(CLASSES)

## run   -> Runs the compiled program
run :
	java -cp "$(BUILD_DIR)" $(MAIN) testFiles/League.ucd
