import unittest


class TestCase:

    def __init__(self, name):
        self.wasSetUp = 1
        self.name = name

    def setUp(self):
        self.test = WasRun("testMethod")

    def run(self):
        self.setUp()
        self.log = "setUp"
        exec ("self." + self.name + "()")


class WasRun(TestCase):

    def __init__(self, name):
        self.wasRun = None
        TestCase.__init__(self, name)

    def setUp(self):
        self.log= "setUp"

    def testMethod(self):
        self.log = self.log + " testMethod"

    def tearDown(self):
        self.log= self.log + "tearDown "


class TestCaseTest(TestCase):

    def setUp(self):
        self.test = WasRun("testMethod")

    def testTemplateMethod(self):
        test = WasRun("testMethod")
        test.run()
        assert ("setUp testMethod" == test.log)
        # assert ("setUp testMethod tearDown" == test.log)


    # Really confusing chapter, no idea what's result and where's testStarted

    # def run(self, result):
    #     result.testStarted()
    #     self.setUp()
    #     exec "self." + self.name + "()"
    #     self.tearDown()


TestCaseTest("testTemplateMethod").run()
