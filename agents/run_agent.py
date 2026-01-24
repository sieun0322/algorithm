import anthropic
import sys

if len(sys.argv) < 3:
    print("Usage: python run_agent.py <agent_file> <input_file>")
    sys.exit(1)

agent_file = sys.argv[1]
input_file = sys.argv[2]

with open(agent_file) as f:
    agent_prompt = f.read()

with open(input_file) as f:
    user_input = f.read()

client = anthropic.Anthropic()

msg = client.messages.create(
    model="claude-sonnet-4-20250514",
    max_tokens=1500,
    messages=[
        {
            "role": "user",
            "content": agent_prompt + "\n\n" + user_input
        }
    ]
)

print(msg.content[0].text)
