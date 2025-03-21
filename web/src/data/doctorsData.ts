import { DoctorCardProps } from "../pages/DoctorList";
import {InformationDoctorProps} from "../components/InformationDoctor.tsx";

export const doctorsData: DoctorCardProps[] = [
    {
        id: 1,
        name: "Nguyễn Văn A",
        specialization: "Tim mạch",
        thumbnail: "data:image/jpeg;base64,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",
        hospital: "Bệnh viện Chợ Rẫy",
        ratings: 4.8,
        price: 500000,
        visit: 120
    },
    {
        id: 2,
        name: "Trần Thị B",
        specialization: "Nhi khoa",
        thumbnail: "data:image/jpeg;base64,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",
        hospital: "Bệnh viện Nhi Đồng 1",
        ratings: 4.7,
        price: 300000,
        visit: 90
    },
    {
        id: 3,
        name: "Lê Văn C",
        specialization: "Da liễu",
        thumbnail: "data:image/jpeg;base64,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",
        hospital: "Bệnh viện Da Liễu",
        ratings: 4.9,
        price: 400000,
        visit: 150
    },
    {
        id: 4,
        name: "Phạm Thị D",
        specialization: "Tai Mũi Họng",
        thumbnail: "data:image/jpeg;base64,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",
        hospital: "Bệnh viện Tai Mũi Họng",
        ratings: 4.6,
        price: 350000,
        visit: 100
    }
];


export const doctorInfo: InformationDoctorProps = {
    header: "Giới thiệu",
    content: "Bác cũng có kinh nghiệm trong tư vấn về hiếm muộn, các biện pháp tránh thai, kế hoạch hóa gia đình, theo dõi thai kỳ, và dinh dưỡng cho thai phụ, cũng như chăm sóc sản phụ sau sinh."
};

export const experienceInfo: InformationDoctorProps = {
    header: "Kinh nghiệm",
    content: "Với hơn 5 năm kinh nghiệm, bác sĩ chuyên môn trong việc khám, tư vấn, và điều trị các bệnh lý Sản Phụ Khoa như u xơ tử cung, u nang buồng trứng, kinh nguyệt không đều, đau bụng kinh."
};