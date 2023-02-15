export interface ActivityModel{
    activity: string,
    type: string
    participants: number,
    price: number,
    link: string,
    key: string,
    accessibility: number
}

export interface GenderModel{
    name: string,
    gender: string,
    probability: number,
    count: number
}