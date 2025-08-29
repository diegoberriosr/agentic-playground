from dotenv import load_dotenv
import os
import requests
import sys

from constants import flags, ROUTE_MAP

def chat(url: str):
    """
    Controls a very basic chat interaction between the user and the chatbot.
    """
    while True:
        try: 
            user_text = input("\033[94m> ")
            response = requests.post(url, data=user_text, headers={"Content-Type": "text/plain"})
            print("\033[92m>" + response.text)
        except KeyboardInterrupt:
            print("\033[95m> \n\n Bye!\033[37m")
            break



def main():
    args_length = len(sys.argv)

    if args_length > 2:
        print("Usage: main.py --endpoint_flag")

    load_dotenv()

    flag = flags.SIMPLE_CHAT_FLAG if args_length == 1 else sys.argv[1]
    url = os.getenv('BACKEND_URL') + ROUTE_MAP.get(flag, flags.SIMPLE_CHAT_FLAG)

    chat(url)


if __name__ == "__main__":
    main()

