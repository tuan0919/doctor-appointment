import axios from 'axios';
import {ApiResponse} from "../types/ApiResponse.ts";
import {DoctorSearchResponse} from "../types/DoctorSearchResponse.ts";
import {ENVIROMENT} from "../data/env.ts";

export class DoctorRepository {
    private DOCTOR_API_URL = `http://${ENVIROMENT.HOST}/api/doctor`;
    searchDoctor = async (keyword: string): Promise<ApiResponse<DoctorSearchResponse>> => {
        const response =
            await axios.get<ApiResponse<DoctorSearchResponse>>(`${this.DOCTOR_API_URL}/search?keyword=${keyword}`, {
        });
        return response.data;
    };
}
