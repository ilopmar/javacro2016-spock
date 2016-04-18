package demo

import spock.lang.Shared
import spock.lang.Specification

class E7_Shared extends Specification {

    @Shared
    def person = new Person('Iván', 'López')

    void 'should get name'() {
        expect:
            println person
    }

    void 'should get lastName'() {
        expect:
            println person
    }

}
