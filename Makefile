CLEAN = $(shell find * -name "*.class" -exec rm -fr {} \;)
FILES = $(shell find * -name "*.java" > sources.txt)
COMP = $(shell javac -d . @sources.txt)

all:
	$(FILES) 
	$(COMP)

clean:
	rm -fr sources.txt

fclean: clean
	$(CLEAN)

re: fclean all
