import { useEffect, useState } from "react"
import DoctorCard from "./DoctorCard"
import http from "../utils/http";

function SearchDoctor() {
    const [doctors, setDoctors] = useState([]);
    const handleSearch = async () => {

        try {
            const response = await http.get<{ data: Doctor[] }>(`search?keyword=${encodeURIComponent(keyword)}`);
            setResults(response.data.data);
        } catch (error) {
            console.error("Lỗi tìm kiếm:", error);
        }
    };
    useEffect(() => {
        const response = await http.get<{ data: Doctor[] }>(`search?keyword=${encodeURIComponent(keyword)}`);
        setResults(response.data.data);
    }, [])

    return (
        <div>
            <DoctorCard />
            <DoctorCard />
            <DoctorCard />
            <DoctorCard />
        </div>
    )
}

export default SearchDoctor
