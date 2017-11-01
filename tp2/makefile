SRC_DIR := src
BUILD_DIR := _build

CLASSPATH := junit-4.12.jar:hamcrest-core-1.3.jar

MAIN = App
TESTS = tests.ParserTest tests.MetricsTest

CLASSES := \
	./src/util/*.java \
	./src/uml/**/*.java \
	./src/uml/*.java \
	./src/metrics/*.java \
	./src/parser/*.java \
	./src/gui/*.java \
	./src/tests/*.java \
	./src/*.java

JAVAC=javac -d $(BUILD_DIR)

## all   -> Base rule : Compiles from scratch and run the program
all: clean build run

## help  -> Shows this help.
help:
	@fgrep -h "##" $(MAKEFILE_LIST) | fgrep -v fgrep | sed -e 's/\\$$//' | sed -e 's/##//'

## clean -> Cleans the build directory
clean :
	-rm -rf $(BUILD_DIR)

## build -> Builds the entire program
build :
	mkdir -p $(BUILD_DIR)
	$(JAVAC) -cp $(CLASSPATH) $(CLASSES)

## run   -> Runs the compiled program
run : build
	java -cp "$(BUILD_DIR)" $(MAIN) testFiles/League.ucd

## test  -> Apply all unit test to compiled program
test: build
	java -cp "$(CLASSPATH):./$(BUILD_DIR)" org.junit.runner.JUnitCore $(TESTS)
