export interface InformationDoctorProps {
    header: string,
    content: string
}

const InformationDoctor: React.FC<InformationDoctorProps> = ({ header, content }) => {
    return (
        <div className="w-full my-6 bg-white shadow-lg rounded-2xl p-6 border border-gray-200">
            <h2 className="text-xl font-semibold text-blue-500 mb-4 text-left">{header}</h2>
            <p className="text-gray-700 mt-3">{content}</p>
        </div>
    );
};

export default InformationDoctor;
