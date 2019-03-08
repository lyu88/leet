// doesn't apply to literal string as char*, but only applies to char array
// my goal is O(1) extra space
void swap(char* s, char* t)
{
	char temp = *s;
	*s = *t;
	*t = temp;
}

char* trim_space_head(char* s)
{
	while (*s == ' ' && *s != '\0')
	{
		s++;
	}
	return s;
}

char* trim_space_middle(char* s)
{
	char* t = s, *head = s;
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
	int len = 0;
	char* head = s;
	while (*s != '\0')
	{
		s++;
		len++;
	}
	reverse_word(head, 0, len - 1);
}

char* reverseWords(char* s)
{
	int start = 0, end = 0;
	char* head;
	s = trim_space_head(s);
	reverse_word_full(s);
	s = trim_space_head(s);
	s = trim_space_middle(s);
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
