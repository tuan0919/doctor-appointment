import InformationDoctor from "../components/InformationDoctor.tsx";
import {doctorInfo, experienceInfo} from "../data/doctorsData.ts";
import DoctorList from "./DoctorList.tsx";

function DoctorDetail() {
    return (
        <div className="max-w">

            <main className="w-full">
                <h1 className="text-center text-2xl font-bold my-4">Chào mừng đến với </h1>
                <InformationDoctor {...doctorInfo}/>
                <InformationDoctor {...experienceInfo}/>
                <div className="bg-white rounded-2xl shadow-lg p-4 border border-gray-200 my-4">
                    <h2 className="text-xl font-semibold text-blue-500 mb-4 text-left">Bác sĩ cùng chuyên khoa</h2>
                    <DoctorList/>

                </div>
            </main>

        </div>
    );
}

export default DoctorDetail;
