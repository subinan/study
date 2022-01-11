class Solution {
	public Boolean is_upper(char c) {
		if (c >= 'A' && c <= 'Z')
			return true;
		return false;
	}
	public Boolean is_valid_char(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') ||
			c == '-' || c == '_' || c == '.')
			return true;
		return false;
	}
	public Boolean check_id(String new_id) {
		int len = new_id.length();

		if (len < 3 || len > 15)
			return false;
		if (new_id.charAt(0) == '.' || new_id.charAt(len -1) == '.')
			return false;
		for (int i = 0; i < len; i++)
		{
			if (is_valid_char(new_id.charAt(i)) == false)
				return false;
		}
		return true;
	}
	public String get_new_id(String new_id) {
		int len = new_id.length();
		StringBuilder answer = new StringBuilder("");
		int ans_len = 0;
		char c;

		for (int i = 0; i < len; i++)
		{
			c = new_id.charAt(i);
			if (is_upper(c))
				c += 32;
			else if (!is_valid_char(c))
				continue;
			else if (c == '.')
			{
				if (ans_len == 0)
					continue;
				if (i == len - 1)
					break;
				if (answer.charAt(ans_len - 1) == '.')
					continue;
			}
			answer.append(c);
			++ans_len;
			if (ans_len >= 15)
				break;
		}
		if (ans_len == 0)
		{
			answer.append('a');
			++ans_len;
		}
    		if (answer.charAt(ans_len - 1) == '.')
		{
			answer.deleteCharAt(ans_len - 1);
			--ans_len;
		}
		c = answer.charAt(ans_len - 1);
		while (ans_len < 3)
		{
			answer.append(c);
			++ans_len;
		}
		return answer.toString();
	}
	public String solution(String new_id) {
		String answer = "";
		if (check_id(new_id) == true)
			answer = new_id;
		else
			answer = get_new_id(new_id);
		return answer;
	}
}
