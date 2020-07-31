import unittest


class TestCase:

    def __init__(self, name):
        self.name = name

    def setUp(self):
        self.wasSetUp = 1
        self.test = WasRun("testMethod")
        self.log = "setUp"

    def run(self):
        result = TestResult()
        result.testStarted()
        self.setUp()
        exec ("self." + self.name + "()")
        self.tearDown()
        return result

    def tearDown(self):
        pass


class WasRun(TestCase):

    def __init__(self, name):
        self.wasRun = None
        TestCase.__init__(self, name)

    def setUp(self):
        self.log = "setUp"

    def testMethod(self):
        self.log = self.log + " testMethod"

    def tearDown(self):
        self.log= self.log + " tearDown"

    def testBrokenMethod(self):
        raise Exception

class TestResult:

    def __init__(self):
        self.runCount = 0

    def testStarted(self):
        self.runCount = self.runCount + 1

    def summary(self):
        return "%d run, 0 failed" % self.runCount


class TestCaseTest(TestCase):

    def testTemplateMethod(self):
        test = WasRun("testMethod")
        test.run()
        assert ("setUp testMethod tearDown" == test.log)

    def testResult1Run0Failed(self):
        test = WasRun("testMethod")
        result = test.run()
        assert ("1 run, 0 failed" == result.summary())

    def testResult1Run1Failed(self):
        test = WasRun("testBrokenMethod")
        result = test.run()
        assert ("1 run, 1 failed" == result.summary())


TestCaseTest("testResult1Run1Failed").run()
