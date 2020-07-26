import unittest


class TestCase:

    def __init__(self, name):
        self.wasSetUp = 1
        self.name = name

    def setUp(self):
        self.test = WasRun("testMethod")

    def run(self):
        #result.testStarted()
        self.setUp()
        self.log = "setUp"
        exec ("self." + self.name + "()")
        self.tearDown()

    def tearDown(self):
        pass


class WasRun(TestCase):

    def __init__(self, name):
        self.wasRun = None
        TestCase.__init__(self, name)

    def setUp(self):
        self.log= "setUp"

    def testMethod(self):
        self.log = self.log + " testMethod"

    def tearDown(self):
        self.log= self.log + " tearDown"


class TestCaseTest(TestCase):

    def testTemplateMethod(self):
        test = WasRun("testMethod")
        test.run()
        assert ("setUp testMethod tearDown" == test.log)

TestCaseTest("testTemplateMethod").run()
