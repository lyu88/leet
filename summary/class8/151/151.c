void swap(char* s, char* t)
{
	char temp = *s;
	*s = *t;
	*t = temp;
}

char* trim_space_2end(char* s)
{
	int len = strlen(s);
	while (len > 0 && *(s+len) == ' ')
	{
		*(s+len) = '\0';
		len--;
	}
	while (*s == ' ' && *s != '\0')
	{
		s++;
	}
	return s;
}

char* trim_space_middle(char* s)
{
	char* t = s, *head = s;
	if (*s == "")
		return s;
	s++;
	t++;
	while (*s != '\0')
	{
		if (*s == ' ' && *(s - 1) == ' ')
		{
			s++;
		}
		else
		{
			*(t++) = *(s++);
		}
	}
	*t = '\0';
	return head;
}

void reverse_word(char* s, int start, int end)
{
	char* left = s + start;
	char* right = s + end;
	while (left < right)
	{
		swap(left++, right--);
	}
}

void reverse_word_full(char* s)
{
	int len = strlen(s);
	reverse_word(s, 0, len - 1);
}

char* reverseWords(char* s)
{
	int start = 0, end = 0;
	char* head;
	s = trim_space_2end(s);
	s = trim_space_middle(s);
	reverse_word_full(s);
	head = s;
	   
	while (*s != '\0')
	{
		if (*s == ' ')
		{
			reverse_word(head, start, end - 1);
			start = end + 1;
		}
		end++;
		s++;
	}
	reverse_word(head, start, end - 1);
	return head;
}