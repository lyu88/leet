char* reverseWords(char* s) 
{

	reverse_word(s, len);

    return s;
}

void swap(char* s, char* t) 
{
	char temp = *s;
	*s = *t;
	*t = temp;
}

char* trim_space_head(char* s)
{
    while (*s == ' ')
    {
    	s++;
    }
    return s;
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
	return len - count;
}

void reverse_word(char* s)
{
	int len = 0;
	while (*s != '\0')
	{
		len++;
		s++;
	}
	for (int i = 0; i < len / 2; i++)
	{
		swap(s+i, s+len-1-i);
	}
}