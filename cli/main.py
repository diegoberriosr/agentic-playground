from dotenv import load_dotenv
import os
import requests


load_dotenv()

CHAT_ENDPOINT =  os.getenv('BACKEND_URL') + 'chat'
print(CHAT_ENDPOINT)

while True:
    try: 
        user_text = input("> ")
        response = requests.post(CHAT_ENDPOINT, data=user_text, headers={"Content-Type": "text/plain"})
        print("$ " + response.text)
    except KeyboardInterrupt:
        break

print("\n\n> Bye!")

