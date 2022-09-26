import axios from "axios";

const client = axios.create({
  baseURL: "http://localhost:8080/start",
  headers: {
    "X-Requested-With": "XMLHttpRequest",
    Accept: "application/json",
    "Access-Control-Allow-Origin": "*",
  },
});

export default async function axiosServices(numberOfAttempts, changeDoor) {
  const info = {
    numberOfAttempts: numberOfAttempts,
    changeDoor: changeDoor,
  };
  return client
    .post("", info)
    .then((res) => res.data)
    .catch((res) => {
      console.log(res);
    });
}
