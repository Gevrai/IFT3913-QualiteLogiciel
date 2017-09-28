ANTLRPATH := ../antler/antlr-4.5.3-complete.jar
BUILD_DIR := _build

# ANTLR4=java org.antlr.v4.Tool
ANTLR4=java -jar $(ANTLRPATH)
GRUN=java org.antlr.v4.gui.TestRig

all: clean prep_env build run

prep_env:
	export CLASSPATH="$(ANTLRPATH):$$CLASSPATH"

clean :
	rm -rf $(BUILD_DIR)

build : build_parser

build_parser : prep_env
	mkdir -p $(BUILD_DIR)
	$(ANTLR4) -o $(BUILD_DIR) grammar/uml_grammar.g4
	javac 

run :
	echo running
