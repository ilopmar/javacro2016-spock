package demo

import spock.lang.Specification

class E8_Mocking extends Specification {

    void 'should send a notification when the someone registers'() {
        given:
            def mockedNotificationService = Mock(NotificationService)
            def userService = new UserService(mockedNotificationService)

        when:
            userService.createUser('Iván', 'López')

        then:
            1 * mockedNotificationService.sendNotification(_, 'User created')
    }

    void 'should check constraints on interactions'() {
        given:
            def mockedNotificationService = Mock(NotificationService)
            def userService = new UserService(mockedNotificationService)

        when:
            userService.createUser('Iván', 'López')

        then:
            1 * mockedNotificationService.sendNotification({it.name == 'Iván'}, 'User created')
    }

    void 'should mock an implementation'() {
        given:
            def person = new Person('Iván', 'López')
            def mockedEmailService = Mock(EmailService)

        when:
            mockedEmailService.sendEmail(person, 'How are you?')

        then:
            1 * mockedEmailService.sendEmail(person, 'How are you?')
    }

    void 'should check the order'() {
        given:
            def person = new Person('Iván', 'López')
            def mockedNotificationService = Mock(NotificationService)

        when:
            mockedNotificationService.sendNotification(person, 'msg1')
            mockedNotificationService.sendNotification(person, 'msg2')
            mockedNotificationService.sendNotification(person, 'msg3')

        then:
            1 * mockedNotificationService.sendNotification(person, 'msg1')

        then:
            1 * mockedNotificationService.sendNotification(person, 'msg2')

        then:
            1 * mockedNotificationService.sendNotification(person, 'msg3')
    }

}
