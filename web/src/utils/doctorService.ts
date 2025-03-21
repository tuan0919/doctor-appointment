import http from "../utils/http"; // Đảm bảo đường dẫn đúng đến file http.ts

export const getDoctors = async () => {
    const response = await http.get("doctor/list");
    return response.data;
};
