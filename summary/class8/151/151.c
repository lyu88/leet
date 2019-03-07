void swap(char* s, char* t) 
{
	char temp = *s;
	*s = *t;
	*t = temp;
}

void trim_space_head(char* s)
{
    while (*s == ' ' && *s != '\0')
    {
    	s++;
    }
}

int trim_space_middle(char* s, int len)
{
	char* t = s, head = s;
	int count = 0;
	s++;
	t++;
	while (*s != '\0')
	{
		if (*s == ' ' && *(s-1) == ' ') 
		{
			s++;
			count++;
		}
		else 
		{
			*(t++) = *(s++);
		}
	}
	*t = '\0';
	s = head;
	return len - count;
}

void reverse_word(char* s, int start, int end)
{
	int len = end - start + 1;
	for (int i = 0; i < len / 2; i++)
	{
		swap(start + i, end - i);
	}
}

char* reverseWords(char* s) 
{

    return s;
}

