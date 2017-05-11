
DOC = doxygen
DOCFLAGS =
DOCCONFIG = doxConfig

####################################################

.PHONY: all  doc clean

doc:
	$(DOC) $(DOCFLAGS) $(DOCCONFIG)
	cd ./docs/latex && $(MAKE)
	cp ./docs/latex/refman.pdf ./TwitterProcessorDocs.pdf

all:  doc

clean:
	rm -rf html
	rm -rf latex
	rm -rf docs