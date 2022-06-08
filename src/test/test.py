import requests

roles_endpoint = 'http://127.0.0.1:8080/roles'
memberships_endpoint = 'http://127.0.0.1:8080/memberships'
roles = [
    {"name": "Tester"},
    {"name": "Product Owner"},
    {"name": "Developer"},
    {"name": "Scrum Master"},
    {"name": "Designer"}
]
memberships = [
    {
        "memberId": "1b140966-5a01-49da-872e-71a769f98941",
        "teamId": "7676a4bf-adfe-415c-941b-1739af07039b",
        "roleName": "Tester"
    }, {
        "memberId": "1b140966-5a01-49da-872e-71a769f98941",
        "teamId": "7676a4bf-adfe-415c-941b-1739af07039b",
        "roleName": "Developer"
    },
]

print("Inserting roles")
for role in roles:
    r = requests.post(url=roles_endpoint, json=role)
    print(r.status_code)

print("Inserting memberships")
for membership in memberships:
    r = requests.post(url=memberships_endpoint, json=membership)
    print(r.status_code)

print("Getting roles")
r = requests.get(url=roles_endpoint)
print(r.text)

print("Getting memberships")
r = requests.get(url=memberships_endpoint)
print(r.text)

print("Look up a membership for a role")
r = requests.get(url=memberships_endpoint+'?roleName=Developer')
print(r.text)

print("Look up a role for a membership")
r = requests.get(url=roles_endpoint+'/search?memberId=1b140966-5a01-49da-872e-71a769f98941&teamId=7676a4bf-adfe-415c-941b-1739af07039b')
print(r.text)
