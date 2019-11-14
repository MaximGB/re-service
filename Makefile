TARGET = jar

.PHONY: clean	run gh

-include ~/secrets/.clojars

all : $(TARGET)


clean:
	rm -rf ./target/


run:
	clj -A\:fig


gh: $(TARGET)
	git push -n origin HEAD


$(TARGET): ./pom.xml ./src/**/*
	clj -Spom
	clj -A\:pack


clojars:
	env CLOJARS_USERNAME=${CLOJARS_USERNAME} CLOJARS_PASSWORD=${CLOJARS_PASSWORD} clj -A:deploy
