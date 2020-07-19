import unittest

class TestCase:

    def __init__(self, name):
        self.wasSetUp = 1
        self.name = name

    def setUp(self):
        self.test = WasRun("testMethod")

    def run(self):
        self.setUp()
        exec("self." + self.name + "()")


class WasRun(TestCase):

    def __init__(self, name):
        self.wasRun = None
        TestCase.__init__(self, name)

    def testMethod(self):
        self.wasRun = 1


class TestCaseTest(TestCase):

    def testSetUp(self):
        self.test.run()
        assert self.test.wasSetUp

    def testRunning(self):
        self.test.run()
        assert self.test.wasRun


TestCaseTest("testRunning").run()
