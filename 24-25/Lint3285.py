class Student:
    # write your code here
    def __init__(self, name, age, gender, english_score, math_score, chinese_score):
        """
        Initialize a Student object with basic information and scores
        
        Args:
            name (str): Student's name
            age (int): Student's age
            gender (str): Student's gender
            english_score (int): English exam score
            math_score (int): Math exam score
            chinese_score (int): Chinese exam score
        """
        self.name = name
        self.age = age
        self.gender = gender
        self.english_score = english_score
        self.math_score = math_score
        self.chinese_score = chinese_score

    def get_message(self):
        """
        Get basic information of the student
        
        Returns:
            str: Formatted string with student's basic information
        """
        return f"name:{self.name} age:{self.age} gender:{self.gender} English score:{self.english_score} Math score:{self.math_score} Chinese score:{self.chinese_score}"
    
    def get_all(self):
        """
        Get the total score of all subjects
        
        Returns:
            int: Sum of English, Math, and Chinese scores
        """
        return f"Total Score:{self.english_score + self.math_score + self.chinese_score}"

    def all(self):
        return self.english_score + self.math_score + self.chinese_score
    
    def get_averexam(self):
        """
        Get the average score of all subjects
        
        Returns:
            float: Average score rounded to 2 decimal places
        """
        total = self.all()
        average = total // 3
        return f"Average score:{average}"