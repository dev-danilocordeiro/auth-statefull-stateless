import os


def docker_compose_up():
    print("Building images and starting containers...")
    os.system("docker compose up --build -d")
    print("Pipeline finished!")


def remove_remaining_containers():
    print("Stopping existing containers...")
    os.system("docker compose down")

    containers = os.popen("docker ps -aq").read().splitlines()
    if containers:
        print(f"There are still {len(containers)} containers running")
        for container in containers:
            print(f"Stopping container {container}")
            os.system(f"docker container stop {container}")

        os.system("docker container prune -f")


if __name__ == "__main__":
    print("Pipeline started!")
    remove_remaining_containers()
    docker_compose_up()